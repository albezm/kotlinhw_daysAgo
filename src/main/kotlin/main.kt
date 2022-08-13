fun main(){
    print("Введи количество секунд: ")
    val inputSeconds = readLine()?.toInt()
    println("Ты ввёл $inputSeconds. Пользователь ${whatOclock(inputSeconds!!)}")
}

fun whatOclock(seconds: Int): String {
    when {
        seconds in 1..59 -> {
            return "заходил только что."
        }
        seconds in 60..3599 -> {
            val minutes = seconds / 60
            val minutesText = minutesDeclencion(minutes)
            return "был $minutes $minutesText назад."
        }
        seconds in 3600..86399 -> {
            val hours = seconds / 3600
            val hoursText = hoursDeclencion(hours)
            return "был $hours $hoursText назад."
        }
        seconds in 86400..172799 -> {
            return "был сегодня."
        }
        seconds in 172800..259199 -> {
            return "заходил вчера."
        }
        seconds > 259200 -> {
            return "заходил тогда, когда динозавры ещё срать ходили."
        }
        else -> {
            return "не пользователь."
        }
    }
}

fun minutesDeclencion(minutes: Int): String {
    var count = minutes % 100
    if (count in 10..20) {
        return "минут"
    }

    count = minutes % 10
    when {
        count == 0 || count > 4 -> {
            return "минут"
        }
        count > 1 -> {
            return "минуты"
        }
        count == 1 -> {
            return "минуту"
        }
        else -> return {""}.toString()
    }
}

fun hoursDeclencion(hours: Int): String {
    var count = hours % 100
    if (count in 10..20) {
        return "часов"
    }

    count = hours % 10
    when {
        count > 4 -> {
            return "часов"
        }
        count > 1 -> {
            return "часа"
        }
        count == 1 -> {
            return "час"
        }
        else -> return {""}.toString()
    }
}
