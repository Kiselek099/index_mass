package com.example.body_mass_index

import android.annotation.SuppressLint
import android.app.ActivityManager.TaskDescription
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    lateinit var viewTV: TextView
    lateinit var imageIV: ImageView
    lateinit var description: TextView
    lateinit var camback: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewTV = findViewById(R.id.viewTV)
        imageIV = findViewById(R.id.imageIV)
        description = findViewById(R.id.description)
        camback = findViewById(R.id.camback)
        camback.setOnClickListener { finish() }
        val bmi=intent.getDoubleExtra("BMI",0.0)
        viewTV.text="Ваш ИМТ: %.2f".format(bmi)
        when(bmi){
            in 0.0..<18.5->{
                description.text="У вас недобор по весу, следуйте интрукциям ниже\n"+
                        "\n"+
                        "Вокруг темы питания для наборы мышечной массы много мифов и ошибочных суждений. Чтобы в этом разобраться, давайте разберём на аналогии.\n" +
                        "\n" +
                        "Олег решил построить дом. Помощь архитектора ему не нужна, потому что в Ютубе уже про это всё сняли, к тому же друзья посоветовали несколько лайфхаков для экономии денег. И вот, наш герой приступил к строительство.\n" +
                        "Сначала Олег решил, что достаточно только нанять рабочих, и не купил никаких строительных материалов. Когда рабочие покрутили у виска, Олег всё-таки купил стройматериалы, но решил обойтись одним утеплителем — зачем тратиться на кирпич, если стена из утеплителя — это и так стена. Когда дом сдуло, Олег увеличил слой утеплителя в 3 раза — так должно быть прочнее. И вот, когда дом в очередной раз развалился, Олег всё-таки обратился к толковому архитектору.\n" +
                        "\n" +
                        "Всё это звучит абсурдно, но то же происходит и в спортзале. Когда люди начинают качать мышцы, они впихивают в себя творог килограммами, избегают углеводов и не подозревают, что калорийности не хватает даже на суточную норму офисного работника. Или к своему привычному рациону из Макдональдса добавляют гейнер, а потом удивляются, что за месяц тренировок вырос не бицепс, а живот. В итоге тренировки ни к чему не приводят, появляется выученная беспомощность, и вся неудача списывается на генетику.\n" +
                        "\n" +
                        "Набор мышечной массы — это система, и если её придерживаться, даже худощавый юноша станет машиной. Главное в этой системе понимать самый важный принцип питания — съедайте ровно столько, сколько нужно вашему организму для роста мышц, и тогда у мышц просто нет шанса не вырасти.\n" +
                        "\n" +
                        "А как это сделать, мы разберёмся дальше."
                imageIV.setImageResource(R.drawable.skinny)
            }
            in 18.5..<35.0->{
                description.text="У вас нормальный вес, продолжайте в том же духе!"
                imageIV.setImageResource(R.drawable.medium)
            }
            else->{
                description.text="У вас избыточный вес, вам нужно похудеть, попробуйте: Ограничения в питании, спорт, мотивация... Базовые способы сбросить лишний вес известны всем, но вот о маленьких, но полезных хитростях знают немногие.\n" +
                        "\n" +
                        "1. Примерную суточную норму килокалорий, при которой вы не будете набирать вес, можно определить по такой формуле Свой вес в килограммах поделите на 0,45 и умножьте на 14. Вес в кг : 0,45 Х 14\n" +
                        "Если же вы хотите не просто оставаться в форме, а похудеть, проделайте то же вычисление, только вместо реального веса подставьте желаемый. Придерживаясь этой заниженной цифры, вы будете терять килограммы — хоть и медленно, но верно.\n" +
                        "\n" +
                        "2. Посыпайте корицей кашу, йогурт, кофе и любую другую пищу, с которой сочетается эта специя. Она обладает способностью ускорять метаболизм, и всего пол чайной ложки в день поможет вам сбрасывать около килограмма за месяц.\n" +
                        "\n" +
                        "3. Если вы едите в офисе, не обедайте за рабочим столом. Исследования показывают, что, сидя перед монитором или экраном телевизора, люди потребляют в среднем на 250 килокалорий больше. \n" +
                        "\n" +
                        "4. Чаще смейтесь. 10-15 минут смеха ежедневно повышают недельный расход калорий на 280 ккал.\n" +
                        "\n" +
                        "5. Благодаря содержанию клетчатки и низкой калорийности морковный сок помогает худеть на 1,8 кг в течение 1,5-2 месяцев. Норма потребления — 1 стакан (200 мл) в день.\n" +
                        "\n" +
                        "6. Принимайте таблетированный кальций. Этот микроэлемент способствует расщеплению жиров и делает этот процесс на 2,6% более эффективным.\n" +
                        "\n" +
                        "7. Во время занятий фитнесом или даже простой прогулки пешком слушайте ритмичную музыку — это мотивирует к физической активности и поможет вам заниматься дольше.\n" +
                        "\n" +
                        "8. Не исключайте из питания нежирное красное мясо. Богатые белком продукты помогают наращивать мышечную массу, а мышечная ткань сжигает гораздо больше калорий, чем жировая, даже в состоянии покоя.\n" +
                        "\n" +
                        "9. Затащите в фитнес-клуб друзей. По статистике, люди, занимающиеся спортом с группой знакомых, худеют на 30% сильнее, чем спортсмены-одиночки.\n" +
                        "\n" +
                        "10. Ешьте меньше соли и больше горького красного перца. Бессолевая диета поможет избавиться от лишней жидкости, а перец содержит вещество капсаицин, ускоряющее обмен веществ на 25%."
                imageIV.setImageResource(R.drawable.fat)
            }
        }


    }
}