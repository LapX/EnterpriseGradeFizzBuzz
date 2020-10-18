import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import javax.ws.rs.core.UriBuilder

fun main(args: Array<String>) {
    val url = UriBuilder.fromUri("http://0.0.0.0/")
        .port(8080)
        .build()

    GrizzlyHttpServerFactory.createHttpServer(
        url,
        Application(),
        true
    )
}