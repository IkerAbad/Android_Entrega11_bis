# Android_Entrega11_bis

App Android en Kotlin (mayo de 2023, ciclo de DAM) que busca álbumes de música en la API pública de búsqueda de iTunes y muestra su carátula, título y artista. Es una segunda versión de [Android_Entrega11](https://github.com/IkerAbad/Android_Entrega11), que hacía lo mismo con películas.

## Qué hay

- Una actividad con navegación entre fragmentos: buscador con el listado de resultados (`search_album`) y detalle del álbum (`detail_album`).
- `AlbumViewModel` con `LiveData` y corrutinas, `ListAlbumAdapter` con `ListAdapter` y `Binding_adapters.kt` para cargar las carátulas con Glide.
- Llamada a `https://itunes.apple.com/search?entity=album&term=...` con Retrofit y Moshi (`services/ApiServices.kt`). No necesita clave.
- Corregí el acceso a la API: el servicio esperaba una lista directa, pero iTunes devuelve un objeto con los álbumes dentro de `results`, y el campo de la carátula tenía mal escrita una mayúscula (`artworkUrl100`).

No he podido compilarla ni ejecutarla aquí: no tengo el SDK de Android en mi entorno de revisión, así que esas correcciones no las he probado.

## Cómo probarlo

Abre el proyecto en Android Studio y ejecútalo en un emulador o dispositivo con conexión a internet.

## Licencia

MIT, ver [LICENSE](LICENSE).

---

# Android_Entrega11_bis (English)

An Android app in Kotlin (May 2023, DAM vocational course) that searches for music albums in the public iTunes Search API and shows their cover, title and artist. It is a second version of [Android_Entrega11](https://github.com/IkerAbad/Android_Entrega11), which did the same with movies.

## What's inside

- One activity with navigation between fragments: a search screen with the results list (`search_album`) and an album detail (`detail_album`).
- `AlbumViewModel` with `LiveData` and coroutines, `ListAlbumAdapter` with `ListAdapter`, and `Binding_adapters.kt` to load covers with Glide.
- A call to `https://itunes.apple.com/search?entity=album&term=...` with Retrofit and Moshi (`services/ApiServices.kt`). No key needed.
- I fixed the API access: the service expected a bare list, but iTunes returns an object with the albums inside `results`, and the cover field had a wrongly capitalised letter (`artworkUrl100`).

I could not compile or run it here: I have no Android SDK in my review environment, so those fixes are untested.

## Trying it

Open the project in Android Studio and run it on an emulator or a device with internet access.

## License

MIT, see [LICENSE](LICENSE).
