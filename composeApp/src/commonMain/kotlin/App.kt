import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
//    LoginViewModel()
//    MyTicketScreen(ticket = sampleTicket)
    MintNFT()
}

val sampleTicket = Ticket(
    id = "1234",
    organizer = "All in Blessings",
    event = "Football",
    time = "7PM - 09/12/2023",
    venue = "San bong bac viet",
    tokenStandard = "ERC1155",
    assetContract = "0xf321...3456"
)