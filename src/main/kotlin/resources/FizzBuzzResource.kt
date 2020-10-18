package resources

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

data class FizzBuzzRequest(val value: String)
data class FizzBuzzResponse(val value: String)

@Path("fizzBuzz")
class FizzBuzzResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun fizzBuzz(fizzBuzzRequest: FizzBuzzRequest): Response? {
        return Response.ok().entity(FizzBuzzResponse("yo")).build()
    }
}