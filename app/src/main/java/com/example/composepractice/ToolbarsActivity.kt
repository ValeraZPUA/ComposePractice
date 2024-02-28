@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ToolbarsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // make app take all screen area, includes system staff like status bar or bottom navigation buttons panel. gives ability to changing status bar color on scroll
        setContent {
            AppScreenToolbar()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun AppScreenToolbar() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior() //to hide topbar on scrolling
    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        TopAppBar(
//        CenterAlignedTopAppBar( //the same as TopAppBar but with center alignment for a title
//        MediumTopAppBar( //title is placed under icons, collapses to TopAppBar view on scroll (if scrollBehavior has been set)
//        LargeTopAppBar( //the same as MediumTopAppBar, but bigger
            title = {
                Text(
                    text = "Screen title",
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                       imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
//                navigationIconContentColor = Color.Red,
//                actionIconContentColor = Color.Blue
                    scrolledContainerColor = Color.Yellow //color of status bar when top bar is hidden by scrolling
                ),
            scrollBehavior = scrollBehavior,
//            windowInsets = WindowInsets(0) // to ignore status bar space
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(100) { item ->
                Text(
                    text = "Item #$item",
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}
