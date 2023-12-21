import io.github.aakira.napier.Napier

class HomeworkLessonSix {
    private var optionalEmail: String? = null

    private val randomNumber by lazy { (0..100).random() }
    private lateinit var userInfo: String

    fun execute() {
        Napier.i("Homework Lesson Six", tag = "Example")
        if (optionalEmail != null) {
            Napier.d("Email is set", tag = "Example")
            userInfo = "User Info with Email: $optionalEmail"
        } else {
            Napier.d("No email", tag = "Example")
        }
        val emailLength = optionalEmail?.length ?: "No email length"
        Napier.d("Email length: $emailLength", tag = "Example")

        Napier.d("Random Number: $randomNumber", tag = "Example")
        Napier.d("Random Number again: $randomNumber", tag = "Example")
    }
}
