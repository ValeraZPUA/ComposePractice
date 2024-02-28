package com.example.composepractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties

class DropDownMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreenDropDownMenu()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun AppScreenDropDownMenu() {
    var showPopMenu by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Popup Menu Example"
        )
        Spacer(modifier = Modifier.height(12.dp))

        Box { // to show dropdown near button calls it
            Button(
                onClick = { showPopMenu = true }
            ) {
                Text(
                    text = "Show"
                )
            }

            DropdownMenu(
                expanded = showPopMenu,
                onDismissRequest = { showPopMenu = false },
//                offset = DpOffset(x = 10.dp, y = 100.dp),
//                properties = PopupProperties() // different props for menu. See it inside this object
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Menu item #1") },
                    onClick = {
                        Toast.makeText(context, "Text #1", Toast.LENGTH_SHORT).show()
                        showPopMenu = false
                    },
                    enabled = false,
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Done, contentDescription = null)
                    },
                    contentPadding = PaddingValues(40.dp),
//                    colors = MenuDefaults.itemColors(
//                        disabledLeadingIconColor = ,
//                        disabledTextColor = ,
//                        disabledTrailingIconColor = ,
//                        leadingIconColor = ,
//                        trailingIconColor = ,
//                        textColor = ,
//                    )
                )
                Divider()
                DropdownMenuItem(
                    text = { Text(text = "Menu item #2") },
                    onClick = {
                        Toast.makeText(context, "Text #2", Toast.LENGTH_SHORT).show()
                        showPopMenu = false
                    }
                )
            }
        }
    }
}
