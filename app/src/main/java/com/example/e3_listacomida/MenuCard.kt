package com.example.e3_listacomida

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.e3_listacomida.data.DataSource
import com.example.e3_listacomida.model.Platillo
import com.example.e3_listacomida.ui.theme.E3_listacomidaTheme

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen circular
            Image(
                painter = painterResource(id = platillo.imagenResId),
                contentDescription = stringResource(id = platillo.nombreResId),
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                // Nombre: tamaño de título
                Text(
                    text = stringResource(id = platillo.nombreResId),
                    style = MaterialTheme.typography.titleLarge
                )
                // Precio: texto normal
                Text(
                    text = stringResource(id = R.string.precio_platillo, platillo.precio),
                    style = MaterialTheme.typography.bodyLarge
                )
                // Oferta: color distinto y en negritas
                Text(
                    text = stringResource(id = R.string.oferta_platillo, platillo.descuento),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Composable
fun MenuCardList(platillos: List<Platillo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(platillos) { platillo ->
            MenuCard(platillo = platillo)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview() {
    val platillos = DataSource().loadPlatillos()
    E3_listacomidaTheme {
        MenuCard(
            platillo = platillos[2],
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCardListPreview() {
    E3_listacomidaTheme {
        MenuCardList(platillos = DataSource().loadPlatillos())
    }
}