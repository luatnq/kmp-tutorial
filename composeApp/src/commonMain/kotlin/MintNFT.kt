import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.enums.NFTType
import data.model.NFT
import data.model.toAddress


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MintNFT() {
    var selectedType by remember { mutableStateOf(NFTType.ERC721) }
    var showNFTTypes by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var nft: NFT? by remember { mutableStateOf(null) }

    TopAppBar(
        title = {
            Text(
                "Mint NFT",
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


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 112.dp,  start= 16.dp, end = 16.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            placeholder = { Text("Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(17.dp))
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID") },
            placeholder = { Text("ID") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(17.dp))
        ExposedDropdownMenuBox(
            expanded = showNFTTypes,
            onExpandedChange = {
                showNFTTypes = !showNFTTypes
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = selectedType.name,
                onValueChange = {},
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "dropdown",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(1.dp)
                            .width(24.dp)
                            .height(24.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ExposedDropdownMenuDefaults.textFieldColors(backgroundColor = Color.Transparent)
            )
            DropdownMenu(
                expanded = showNFTTypes,
                modifier = Modifier.fillMaxWidth(),
                onDismissRequest = { showNFTTypes = false }
            ) {
                NFTType.values().toList().forEach { type ->
                    DropdownMenuItem(onClick = {
                        selectedType = type
                        showNFTTypes = false
                    }) {
                        Text(text = type.name, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(17.dp))
        Button(onClick = {
            val nftId = id.toIntOrNull() ?: return@Button
            nft = when (selectedType) {
                NFTType.ERC721 -> NFT.ERC721(name, nftId)
                NFTType.ERC1155 -> NFT.ERC1155(name, nftId)
            }
        }) {
            Text("MINT")
        }

        Spacer(modifier = Modifier.height(30.dp))
        nft?.let {
            NFTItem("Event name", "${it.name}")
            NFTItem("Type", "${selectedType.name}")
            NFTItem("ID", "${it.id}")
            NFTItem("Address", "${it.toAddress()}")
        }
    }
}

@Composable
fun NFTItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF767676),

            letterSpacing = 0.5.sp,
        ))
        Text(value, style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),

            textAlign = TextAlign.Right,
            letterSpacing = 0.5.sp,
        ))
    }

    Spacer(Modifier.height(8.dp))
}

