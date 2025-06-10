package com.example.pendapetro.data.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pendapetro.R
import com.example.pendapetro.data.dao.CategoryDao
import com.example.pendapetro.data.dao.QuestionDao
import com.example.pendapetro.data.entitys.Category
import com.example.pendapetro.data.entitys.Question
import com.example.pendapetro.data.entitys.QuestionCategory
import com.example.pendapetro.utils.Converters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Question::class, Category::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MainDb : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: MainDb? = null

        fun getInstance(context: Context): MainDb {
            Log.d("DatabaseInit", "getInstance called")
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDb::class.java,
                    "main_db"
                )
                    .addCallback(prepopulateCallback)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                Log.d("DatabaseInit", "Database instance created")
                instance
            }
        }

        private val prepopulateCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    INSTANCE?.questionDao()?.insertAll(prepopulateQuestions())
                    INSTANCE?.categoryDao()?.insertCategories(prepopulateCategories())
                }
            }
        }

        private fun prepopulateCategories(): List<Category> {
            return listOf(
                Category(
                    QuestionCategory.BASICS_OF_INVESTING_1,
                    "Los conceptos básicos de la inversión en petróleo y gas",
                    categoryDescription = "Para que los principiantes comprendan los principios básicos.",
                    categoryIcon = R.drawable.oil_drum,
                    categoryImg = R.drawable.category_1_img,
                ),
                Category(
                    QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2,
                    "Análisis de mercado y precios",
                    categoryDescription = "Para usuarios que quieran entender qué influye en los cambios en los precios del petróleo y el gas.",
                    categoryIcon = R.drawable.grafik,
                    categoryImg = R.drawable.category_2_img,
                ),
                Category(
                    QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3,
                    "Infraestructura y empresas",
                    categoryDescription = "Para inversores que estudian empresas energéticas y cadenas de suministro.",
                    categoryIcon = R.drawable.factory,
                    categoryImg = R.drawable.category_3_img,
                ),
                Category(
                    QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4,
                    "Instrumentos y estrategias financieras",
                    categoryDescription = "Para usuarios experimentados que quieran dominar herramientas y estrategias de inversión.",
                    categoryIcon = R.drawable.money,
                    categoryImg = R.drawable.category_4_img,
                )
            )
        }

        private fun prepopulateQuestions(): List<Question> {
            return listOf(
                // BASICS_OF_INVESTING_1 — Fundamentos de inversión
                Question(
                    questionText = "¿Qué es una acción?",
                    answers = listOf("Parte de propiedad en una empresa", "Un tipo de préstamo", "Un seguro"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),
                Question(
                    questionText = "¿Qué significa diversificación en inversiones?",
                    answers = listOf("Distribuir el capital en diferentes activos", "Invertir solo en petróleo", "Ahorrar todo en efectivo"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),
                Question(
                    questionText = "¿Qué es un dividendo?",
                    answers = listOf("Pago de beneficios a los accionistas", "Tipo de impuesto", "Una deuda bancaria"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),
                Question(
                    questionText = "¿Qué riesgo es común en la inversión en petróleo?",
                    answers = listOf("Volatilidad del precio", "Garantía de ganancia", "Rendimiento fijo"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),
                Question(
                    questionText = "¿Qué es un activo?",
                    answers = listOf("Algo que tiene valor y genera ingresos", "Una deuda pendiente", "Un gasto"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),
                Question(
                    questionText = "¿Qué es un portafolio de inversión?",
                    answers = listOf("Conjunto de inversiones de un inversor", "Un préstamo bancario", "Un tipo de acción"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),
                Question(
                    questionText = "¿Qué es la liquidez?",
                    answers = listOf("Facilidad para convertir un activo en efectivo", "Rentabilidad garantizada", "Pago de dividendos"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.BASICS_OF_INVESTING_1
                ),

                // MARKET_ANALYSIS_AND_PRICING_2 — Análisis de mercado y precios
                Question(
                    questionText = "¿Qué afecta principalmente el precio del petróleo?",
                    answers = listOf("Oferta y demanda global", "La tasa de interés", "El tipo de cambio"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),
                Question(
                    questionText = "¿Qué es la OPEP?",
                    answers = listOf("Organización de países exportadores de petróleo", "Una empresa petrolera", "Un banco central"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),
                Question(
                    questionText = "¿Qué indicador se usa para medir precios internacionales del petróleo?",
                    answers = listOf("WTI y Brent", "IPC", "NASDAQ"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),
                Question(
                    questionText = "¿Qué es un contrato de futuros en petróleo?",
                    answers = listOf("Acuerdo para comprar o vender petróleo en el futuro a precio fijo", "Un tipo de acción", "Un impuesto especial"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),
                Question(
                    questionText = "¿Qué puede causar una caída del precio del petróleo?",
                    answers = listOf("Exceso de oferta", "Conflictos bélicos", "Aumento en la demanda"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),
                Question(
                    questionText = "¿Qué es la volatilidad en los mercados petroleros?",
                    answers = listOf("Variación rápida y significativa de precios", "Precio estable", "Ganancia segura"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),
                Question(
                    questionText = "¿Qué influencia tiene la economía global en el mercado petrolero?",
                    answers = listOf("Determina la demanda y precios", "No tiene impacto", "Solo afecta impuestos"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2
                ),

                // INFRASTRUCTURE_AND_COMPANIES_3 — Infraestructura y empresas
                Question(
                    questionText = "¿Qué es una refinería de petróleo?",
                    answers = listOf("Planta que procesa petróleo crudo en productos", "Pozo petrolero", "Compañía de transporte"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),
                Question(
                    questionText = "¿Qué función tiene un oleoducto?",
                    answers = listOf("Transportar petróleo por tuberías", "Extraer petróleo", "Refinar petróleo"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),
                Question(
                    questionText = "¿Qué compañía es una de las mayores petroleras internacionales?",
                    answers = listOf("ExxonMobil", "Apple", "Samsung"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),
                Question(
                    questionText = "¿Qué es el gas natural?",
                    answers = listOf("Combustible fósil gaseoso", "Un mineral sólido", "Un producto refinado"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),
                Question(
                    questionText = "¿Qué es la perforación petrolera?",
                    answers = listOf("Proceso para extraer petróleo del subsuelo", "Transporte de petróleo", "Comercialización"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),
                Question(
                    questionText = "¿Qué es un yacimiento petrolífero?",
                    answers = listOf("Lugar con reservas de petróleo", "Una refinería", "Un mercado bursátil"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),
                Question(
                    questionText = "¿Cuál es la importancia de la infraestructura en la industria petrolera?",
                    answers = listOf("Permite la extracción y transporte eficiente", "Genera impuestos", "Reduce la demanda"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3
                ),

                // FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4 — Instrumentos financieros y estrategias
                Question(
                    questionText = "¿Qué es un contrato de opción en petróleo?",
                    answers = listOf("Derecho a comprar o vender petróleo a precio fijo", "Compra inmediata de petróleo", "Un impuesto especial"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                ),
                Question(
                    questionText = "¿Qué es un ETF relacionado con energía?",
                    answers = listOf("Fondo que invierte en empresas energéticas", "Un tipo de préstamo", "Una acción individual"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                ),
                Question(
                    questionText = "¿Qué significa apalancamiento en finanzas?",
                    answers = listOf("Uso de deuda para aumentar la inversión", "Ahorro sin riesgos", "Pago de dividendos"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                ),
                Question(
                    questionText = "¿Qué estrategia protege contra la caída de precios del petróleo?",
                    answers = listOf("Cobertura (hedging)", "Especulación", "Aumento de producción"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                ),
                Question(
                    questionText = "¿Qué es una obligación (bond) energética?",
                    answers = listOf("Deuda emitida por empresas energéticas", "Acción de empresa", "Contrato de futuros"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                ),
                Question(
                    questionText = "¿Qué es un índice bursátil energético?",
                    answers = listOf("Medición del rendimiento de acciones energéticas", "Precio del petróleo", "Tipo de cambio"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                ),
                Question(
                    questionText = "¿Qué significa diversificación en estrategias financieras?",
                    answers = listOf("Distribuir inversiones para reducir riesgos", "Invertir solo en petróleo", "Mantener todo en efectivo"),
                    correctAnswerIndex = 0,
                    category = QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
                )
            )
        }
    }
}