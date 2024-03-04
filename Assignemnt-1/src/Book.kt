open class Book(var title: String,var author:String,var price: Int) {
    open fun read(){
        println("Reading Paper book")
    }
}
class EBook(title: String,  author:String, price: Int, fileType: String) : Book(title, author, price){
    override fun read(){
        println("read from Electronic device")
    }
}
class Test {
    fun test(){
        var book = Book("Journey to west", "Unknown",99)
        var ebook = EBook("Journey to west", "Unknown",99,"PDF")
        book.read()
        ebook.read()
        book.title = "Journey"
        println(book.title)
        println("Journey")
    }
}