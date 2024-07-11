package com.cristopher.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cristopher.composearticle.ui.theme.ComposeArticleTheme

typealias Paragragph = Int
val paragraphs: MutableList<Paragragph> = mutableListOf(R.string.first_paragraph, R.string.second_paragraph)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Article(image = painterResource(id = R.drawable.bg_compose_background), title = stringResource(id = R.string.article_title),
                        content = paragraphs)
                }
            }
        }
    }
}

@Composable
fun Article(image: Painter, title: String, content: MutableList<Paragragph>, modifier: Modifier = Modifier) {
   Column(modifier = Modifier.fillMaxSize()) {
       Image(painter = image,
           contentDescription = null,
           modifier = Modifier.fillMaxWidth()
       )
       Text(text = title, fontSize = 24.sp,
           modifier = Modifier.padding(16.dp)
       )
       content.forEach { paragraph ->
           Text(text = stringResource(id = paragraph), textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))
       }
   }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Article(image = painterResource(id = R.drawable.bg_compose_background), title = stringResource(id = R.string.article_title),
            content = paragraphs)
    }
}