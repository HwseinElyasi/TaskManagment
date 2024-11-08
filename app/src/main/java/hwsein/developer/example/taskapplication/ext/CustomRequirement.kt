package hwsein.developer.example.taskapplication.ext

enum class SetView {

    HOME, DOCUMENT, SEARCH, ABOUT

}

interface ActiveItem {

    fun activeView(activeItem: SetView)

}