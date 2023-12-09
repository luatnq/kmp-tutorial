import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Ticket(
    val id: String,
    val organizer: String,
    val event: String,
    val time: String,
    val venue: String,
    val tokenStandard: String,
    val assetContract: String
)


@Composable
fun MyTicketScreen(ticket: Ticket) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "My Ticket",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.15.sp,
                        ),
                        modifier = Modifier
                            .width(272.dp)
                            .height(24.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Go back",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(1.dp)
                                .width(24.dp)
                                .height(24.dp)
                        )
                    }
                },
                backgroundColor = Color(0xFF6200EE),
                elevation = 0.dp,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(top = 24.dp),
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color(0xFF6200EE),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .background(color = Color(0xFF6200EE))
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .width(276.dp)
                            .height(44.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF383838)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Check in",
                            style = TextStyle(
                                fontSize = 17.sp,
                                lineHeight = 23.8.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .width(147.dp)
                                .height(24.dp)
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .height(44.dp)
                            .width(44.dp)
                            .background(Color(0xFF767676), RoundedCornerShape(8.dp))
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = "Go to next",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(1.dp)
                                .width(24.dp)
                                .height(24.dp)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            TicketContent(
                ticket
            )
        }
    }

}

@Composable
fun TicketContent(ticket: Ticket) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(328.dp)
                .height(343.dp)
                .background(
                    color = Color(0xFF979797),
                    shape = RoundedCornerShape(size = 12.dp)
                )
                .padding(start = 81.dp, end = 81.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("My Ticket #${ticket.id}", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider()

        TicketItem("Organizer", ticket.organizer)
        TicketItem("Event name", ticket.event)
        TicketItem("Time", ticket.time)
        TicketItem("Venue", ticket.venue)
        TicketItem("Token Standard", ticket.tokenStandard)
        TicketItem("Asset contract", ticket.assetContract)


        OutlinedButton(
            onClick = {  },
            modifier = Modifier
                .width(331.dp)
                .height(40.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
                .padding(start = 8.dp, end = 8.dp),
            border = BorderStroke(1.dp, Color(0xFF000000)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF6200EE)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "View on Google Maps",

                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        letterSpacing = 0.5.sp,
                    ),
                    modifier = Modifier
                        .width(164.dp)
                        .height(24.dp)
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Go to next",
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }

    }
}

@Composable
fun TicketItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.h6)
        Text(value, style = MaterialTheme.typography.body1)
    }

    Spacer(Modifier.height(8.dp))
}

