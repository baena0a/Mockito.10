import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import junio2013.Anuncio;
import junio2013.IBaseDeDatosDeAnunciantes;
import junio2013.IBaseDeDatosDePagos;
import junio2013.TablonDeAnuncios;

public class TablonAnunciosTest {

private TablonDeAnuncios listaAnuncio;
private static final IBaseDeDatosDeAnunciantes baseAnunciante = null;
private static final IBaseDeDatosDePagos basePagos = null;

	@Before
	public void SetUp(){
		listaAnuncio = new TablonDeAnuncios();
	}
	@Test
	public void Test1() {
		assertEquals(1, listaAnuncio.anunciosPublicados());
	}
	@Test
	public void Test2() {
		Anuncio anun = new Anuncio("", "", "LA EMPRESA");
		listaAnuncio.publicarAnuncio(anun, baseAnunciante,basePagos);
		assertEquals(2, listaAnuncio.anunciosPublicados());
		
	}	
	@Test
	public void Test3() throws Exception {
		
	}


}
