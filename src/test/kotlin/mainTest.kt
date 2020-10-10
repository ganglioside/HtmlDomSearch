import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.junit.jupiter.api.Test

class MainTest {

    private val blockFragmentHtml   = "<h1>반갑습니다. 안녕하세요.<span gender=“male”>배우 이순신입니다.<span pitch=\"1.5\">장군의 목소리를 갖고 있어요.</span>여러분도 그렇게 들으셨나요?</span>다음에 뵙겠습니다.</h1>"
    private val doc: Document       = Jsoup.parseBodyFragment(blockFragmentHtml)
    private val body: Element       = doc.body()

    @Test fun `searchRecursiveDFS returns `() {

    }
}