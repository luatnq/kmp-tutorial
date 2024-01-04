package data.model

import com.appmattus.crypto.Algorithm
import com.appmattus.crypto.Digest

sealed class NFT(val name: String, val id: Int) {
    data class ERC721(val nftName: String, val nftId: Int) : NFT(nftName, nftId)
    data class ERC1155(val nftName: String, val nftId: Int) : NFT(nftName, nftId)

}

@OptIn(ExperimentalStdlibApi::class)
fun NFT.toAddress(): String {
    val digest = Algorithm.SHA_256.createDigest()
    val hashBytes = digest.digest(this.toString().encodeToByteArray())
    val hexString = hashBytes.toHexString()
    return "0x${hexString.substring(0, 5)}...${hexString.takeLast(5)}"
}



