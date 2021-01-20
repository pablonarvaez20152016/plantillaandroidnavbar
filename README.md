# TREEAPP
### La aplicación utiliza directamente tres apis de  datos colombia:

- Mapa de sitios culturales del municipio de Pasto a 25-04-2019
[url api sitios culturales](https://www.datos.gov.co/Salud-y-Protecci-n-Social/Mapa-de-sitios-culturales-del-municipio-de-Pasto-a/4zbg-ky2h)
- Sitios Wifi de San Juan de Pasto
- Escenarios Deportivos de San Juan de Pasto [Url api escenarios deportivos](https://www.datos.gov.co/Funci-n-p-blica/Escenarios-Deportivos-Municipio-De-PASTO/vx6j-j5fb)


Y una indirectamente ya que solo se utiliza la url concadenando una búsqueda aleatoria
[Unsplash](https://unsplash.com/).

### Pantalla de Inicio
![cargando imagen](https://lh4.googleusercontent.com/nrac88x4-DS5_mpIpufYP5K3h1I1DuZawYpr4xmdpI_CIxs-jidmTu4_L_5i33DEOJqkKQnbXwuIr0TMfg-VwJ9GSLmFsPtPyrk0f8Xa)
![cargando imagen](https://lh6.googleusercontent.com/syiJcvwCEAHoFJmWBf49ExcU-K3JgQP1UHR8dIxyqwfUgR7j7rEuEKV45-JNzudtVeUrIdnx_Vpmx2KoarhFo3Zhidp8uJMVzmJVR1rh)

La aplicación se realizó con una plantilla que suministra Android Studio, a la cual se adecuo según las necesidades, además se modificaron los colores que bien por defecto también se agregaron recursos nuevos como el degradado.xml, fondocarviewsite.xml que ayudan a dar opciones de color rápidos de cambiar.
Se realiza una nueva Activity para el SplashScreen y se realizan los respectivos cambios, luego de eso se generan las clases de acuerdo a datos json ofrecidos por las apis. Con la apiservice e  interface correspondiente se verifica que los datos son bien capturados.
Para mostrarlos en cada Fragment se realizan diseños de carview para cada uno de ellos, que en cada RecyclerView se adecuan por medio de un adaptador que ayuda la interfaz de la app.

Con esta explicación breve la app logra mostrar información correspondiente a la ciudad de Pasto.

![cargando imagen](https://lh6.googleusercontent.com/Ur2TL63f3MMqdGrTmp0nS0FgwufKNzNuNq6G_aQyzq_59yWsA9m7Ocme-GzFJMzfoiitxbyUcA4btWDk7UszPv7OndKFSUZPiJ8tg8TR)
![cargando imagen](https://lh3.googleusercontent.com/TAKRW-ZiExzV6NxHx1LltH6gJTtm4GTgmfz-snZ-rShHpA5RBkVqMIkU71g_JLX57Uc3C55fGExvLi3OZfpVLFEH7j3l8VzU8LcfXcrV)


![cargando imagen](https://lh4.googleusercontent.com/nDcPZ5YlEkIZJVYCQtzpVGPOVPQl_d8LsxohQbO5oxVsjAchyWcUt4oPQESGxQ3LZNDHzD2ioxuaD-NdWEDGLJee6URwD6Nh3PT6Y0hU)
![cargando imagen](https://lh3.googleusercontent.com/TAKRW-ZiExzV6NxHx1LltH6gJTtm4GTgmfz-snZ-rShHpA5RBkVqMIkU71g_JLX57Uc3C55fGExvLi3OZfpVLFEH7j3l8VzU8LcfXcrV)
![cargando imagen](https://lh5.googleusercontent.com/a6YJHPbBCIsPBMiKw0EqKvRwjqgYY0F4w5UTt8JsMyLyvkLHsO_XLiGfPtHYUL0gdIQLbUXYwa6etx4hwFeQw5EpZFjuhdkR-wFiWSCN)
![cargando imagen](https://lh4.googleusercontent.com/caDuO74CmIJvHUQUWmnm-ZWmr-I0wSDIh1p5hg6XtG_0-riG9xWaVIuvodfepGV33-QkgXKHmpDnmoKQmhYszzwZ3lSo5Tj_iwEMupmZ)

