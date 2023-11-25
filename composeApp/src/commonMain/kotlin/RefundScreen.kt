import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RefundRequestScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Refund request", style = MaterialTheme.typography.h4)

        Spacer(Modifier.height(24.dp))

        DetailItem("Customer name", "Law nguyen")
        DetailItem("Address", "0x657...a3f")
        DetailItem("Event name", "The event")
        DetailItem("Event date", "25/11/2023")
        DetailItem("Refund request date", "24/11/2023")

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        ) {
            Button(onClick = { println("Refund request approved on ${platformName()}") }) {
                Text("APPROVE")
            }
            Button(onClick = { println("Refund request declined on ${platformName()}") }) {
                Text("DECLINE")
            }
        }
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.h6)
        Text(value, style = MaterialTheme.typography.body1)
    }

    Spacer(Modifier.height(8.dp))
}
