package org.angelldca.helloworld.screen.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import org.angelldca.helloworld.data.remote.Movie
import org.angelldca.helloworld.data.remote.movies
import org.angelldca.helloworld.screen.ui.screen
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScren(onMovieClick :(Movie) -> Unit){


    screen{
        var scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(stringResource(Res.string.app_name))},
                    scrollBehavior = scrollBehavior
                ) },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { padding ->
            LazyVerticalGrid(
                columns = GridCells.Adaptive(120.dp),//cada elemento ocupa 120 dp
                contentPadding = PaddingValues(4.dp),
                //separacion horizontal y vertical
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(padding),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ){
                items(movies,key= {it.id}){
                    movieItems(movie = it,onClick = {onMovieClick(it)})
                }
            }
        }

    }
}

@Composable
fun movieItems (movie: Movie,onClick :() -> Unit){
    Column(
        modifier = Modifier.clickable(onClick=onClick)
    ) {
        SubcomposeAsyncImage(
            model = movie.poster,
            contentDescription = "Test ${movie.title}",
            contentScale = ContentScale.Crop,
            loading = { CircularProgressIndicator() },
            error = { Text("Error cargando imagen") },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2/3f)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.primary)

        )
        Text(
            "Test ${movie.title}",
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier.padding(8.dp)
        )
    }
}