package com.aldoj.yournewsapp.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aldoj.yournewsapp.R
import com.aldoj.yournewsapp.ui.theme.YourNewsAppTheme


sealed class BottomBarItem(@StringRes val title: Int, val route: String, val icon: ImageVector) {
    data object ForYou : BottomBarItem(
        title = R.string.for_you_title,
        route = AppGraph.main.FOR_YOU_SCREEN,
        icon = Icons.Filled.Person
    )

    data object Top : BottomBarItem(
        title = R.string.top_news, route = AppGraph.main.TOP_NEWS_SCREEN, icon = Icons.Filled.Star
    )

    data object Favorites : BottomBarItem(
        title = R.string.favorites_title,
        route = AppGraph.main.FAVORITES_SCREEN,
        icon = Icons.Filled.Favorite
    )
}

object BottomBarConfigList {
    val list = listOf(
        BottomBarItem.ForYou,
        BottomBarItem.Top,
        BottomBarItem.Favorites,
    )
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showNavigationItems = BottomBarConfigList.list.any { it.route == currentRoute }

    YourNewsAppTheme {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomBarConfigList.list.forEach {
                NavigationBarItem(modifier = Modifier.align(Alignment.CenterVertically),
                    selected = currentRoute == it.route,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primary,
                        selectedIconColor = MaterialTheme.colorScheme.background,
                        unselectedIconColor = MaterialTheme.colorScheme.onBackground
                    ),
                    label = {
                        Text(
                            text = stringResource(id = it.title),
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = it.icon, contentDescription = "icon-bottom-bar"
                        )
                    },
                    onClick = { if (currentRoute != it.route) navController.navigate(it.route) })
            }
        }
    }
}