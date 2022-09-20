package com.coderz.f1.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderz.f1.card.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        ItemCard(
                            name = "Carl",
                            subName = "Williams",
                            index = 1,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(9.dp)

                        )
                    }

                }
            }
        }
    }
}


@Composable
fun ItemCard(
    name: String,
    subName: String,
    index: Int,
    modifier: Modifier = Modifier,
    cardRadius: Dp = 8.dp,
    cardBackgroundColor:Color = MaterialTheme.colors.surface.copy(alpha=.5f),
    nameStyle: TextStyle = MaterialTheme.typography.h6,
    nameColor: Color = MaterialTheme.colors.onSurface,
    subNameStyle: TextStyle = MaterialTheme.typography.body1,
    subNameColor: Color = MaterialTheme.colors.onSurface.copy(alpha = .5f),
    borderColor: Color = MaterialTheme.colors.primary.copy(.25f),
    borderThickness: Dp = 1.dp,
    indexBackgroundColor: Color = MaterialTheme.colors.primaryVariant.copy(.5f),
    indexTextColor:Color = MaterialTheme.colors.onSurface
) {
    Card(
        shape = RoundedCornerShape(cardRadius),
        modifier = modifier,
        backgroundColor = cardBackgroundColor,
        border = BorderStroke(borderThickness, borderColor),
        elevation = 0.dp

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),


            ) {
            Column(
                modifier = Modifier
                    .weight(1f),

                ) {
                Text(
                    text = name,
                    style = nameStyle,
                    color = nameColor,
                    modifier = Modifier
                        .padding(8.dp, 8.dp, 8.dp, 0.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subName,
                    style = subNameStyle,
                    color = subNameColor,
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 8.dp, 8.dp)
                )
            }
            Box(
                modifier = Modifier
                    .width(48.dp)
                    .background(indexBackgroundColor)
                    .fillMaxHeight()

            ) {
                Text(
                    text = "$index",
                    modifier = Modifier
                        .align(Alignment.Center),
                    fontSize = 18.sp,
                    color = indexTextColor
                )
            }
        }
    }
}