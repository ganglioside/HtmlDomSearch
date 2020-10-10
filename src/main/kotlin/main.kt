import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.Node
import org.jsoup.nodes.TextNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 이 예제는 Jsoup 라이브러리를 사용하여 HTML5 DOM Tree를 분석한다. 그런 다음,
 * 기존의 DOM Tree의 탐색 방식은 BFS(너비 우선 탐색)이지만 여기에서는 DFS(깊이 우선 탐색)으로 탐색해본다.
 */
fun main(args: Array<String>) {
    val blockFragmentHtml   = "<h1>반갑습니다. 안녕하세요.<span gender=“male”>배우 이순신입니다.<span pitch=\"1.5\">장군의 목소리를 갖고 있어요.</span>여러분도 그렇게 들으셨나요?</span>다음에 뵙겠습니다.</h1>"
    val doc: Document       = Jsoup.parseBodyFragment(blockFragmentHtml)
    val body: Element       = doc.body()

    searchRecursiveDFS(body)
//    searchIterativeDFS(body)
}

/**
 * DOM Tree의 특정 노드를 재귀적인 DFS으로 탐색하는 함수
 * @param root 부모 노드
 */
fun searchRecursiveDFS(root: Node) {
    for (childNode: Node in root.childNodes()) {
        if (childNode is TextNode && !(childNode as TextNode).isBlank) {
            println(childNode.text())
        } else searchRecursiveDFS(childNode)
    }
}

/**
 * DOM Tree의 특정 노드를 반복적으로 DFS로 탐색하는 함수
 * @param root 부모 노드
 */
fun searchIterativeDFS(root: Node) {
    val stack: Stack<Node> = Stack()
    stack.push(root)
    while (stack.isNotEmpty()) {
        when (val node: Node = stack.pop()) {
            is TextNode -> println(node.text())
            else        -> {
                val nodes: List<Node> = ArrayList<Node>(node.childNodes())
                Collections.reverse(nodes)

                for (childNode: Node in nodes) {
                    stack.push(childNode)
                }
            }
        }
    }
}

/*
 * 자료구조를 사용한 웹 크롤러 원리1 (DFS)
 * https://blog.naver.com/jwyoon25/221337438111
 */