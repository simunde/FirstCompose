package com.msid.firstcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msid.firstcompose.R

@Preview(heightDp = 500)
@Composable
fun PreviewItem() {

//    Column(Modifier.verticalScroll(rememberScrollState())) {
//        getCategory().map { item->
//            BlogCategory(img = item.img, title = item.title, subTitle = item.subTitle)
//        }
//    }


    LazyColumn(content = {
        items(getCategory()){ item ->
            BlogCategory(img = item.img, title = item.title, subTitle = item.subTitle)
        }
    })
}

@Composable
fun BlogCategory(img: Int, title: String, subTitle: String) {


    // Define custom elevations
    val customElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,  // Elevation when the card is at rest
        pressedElevation = 12.dp, // Elevation when the card is pressed
        focusedElevation = 10.dp, // Elevation when the card is focused
        hoveredElevation = 9.dp   // Elevation when the card is hovered over
    )
    Card(elevation = customElevation, modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )

            ItemDescription(title, subTitle, Modifier.weight(0.8f))
        }

    }
}

@Composable
private fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(
        modifier = modifier,

    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold

        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Thin,
        )
    }
}

data class Category(val img: Int, val title: String, val subTitle: String)

fun getCategory(): MutableList<Category> {
    val list  = mutableListOf<Category>()

    list.add(Category(R.drawable.a, "Programming", "Learning Java"))
    list.add(Category(R.drawable.b, "Web Development", "Exploring HTML & CSS"))
    list.add(Category(R.drawable.c, "Mobile Apps", "Building with Android"))
    list.add(Category(R.drawable.d, "Data Science", "Data Analysis with Python"))
    list.add(Category(R.drawable.a, "Machine Learning", "Algorithms and Models"))

    list.add(Category(R.drawable.b, "Cyber-security", "Protecting Digital Assets"))
    list.add(Category(R.drawable.c, "Cloud Computing", "Services on AWS"))
    list.add(Category(R.drawable.d, "Internet of Things", "Connecting Smart Devices"))
    list.add(Category(R.drawable.a, "Blockchain", "Understanding Cryptocurrencies"))
    list.add(Category(R.drawable.b, "Game Development", "Using Unity Engine"))


    list.add(Category(R.drawable.a, "Programming", "Learning Java"))
    list.add(Category(R.drawable.b, "Web Development", "Exploring HTML & CSS"))
    list.add(Category(R.drawable.c, "Mobile Apps", "Building with Android"))
    list.add(Category(R.drawable.d, "Data Science", "Data Analysis with Python"))
    list.add(Category(R.drawable.a, "Machine Learning", "Algorithms and Models"))

    return list
}