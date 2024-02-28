@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class Tab(
    val label: String,
    val icon: ImageVector
) {
    Items("Items", Icons.Default.List),
    Settings("Settings", Icons.Default.Settings),
    Profile("Profile", Icons.Default.AccountBox)
}

class BottomNavigationBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreenBottomNavBar()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun AppScreenBottomNavBar() {
    var currentTab by remember {
        mutableStateOf(Tab.Items)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopAppBar(
            title = { Text(text = currentTab.label) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .weight(1.0f)
        ) {
            TabScreen(tab = currentTab)
        }

        NavigationBar {
            Tab.entries.forEach { tab ->
                NavigationBarItem(
                    selected = tab == currentTab,
                    onClick = { currentTab = tab },
                    icon = {
                        Icon(
                            imageVector = tab.icon,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = tab.label)
                    },
//                enabled = false,
//                alwaysShowLabel = false // to hide label for unselected buttons,
                    /*colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.Blue,
                        selectedIconColor = Color.Red,
                        disabledIconColor = Color.Gray,
                        unselectedTextColor = Color.Blue,
                        selectedTextColor = Color.Red,
                        disabledTextColor = Color.Gray,
                        indicatorColor = Color.Yellow
                    ),*/
                )
            }
        }
    }
}

@Composable
fun ItemsScreen() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.items_screen),
            fontSize = 28.sp
        )
    }
}

@Composable
fun SettingsScreen() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Settings Screen",
            fontSize = 28.sp
        )
    }
}

@Composable
fun ProfileScreen() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Profile Screen",
            fontSize = 28.sp
        )
    }
}

@Composable
fun TabScreen(tab: Tab) {
    when (tab) {
        Tab.Items -> ItemsScreen()
        Tab.Settings -> SettingsScreen()
        Tab.Profile -> ProfileScreen()
    }

}
