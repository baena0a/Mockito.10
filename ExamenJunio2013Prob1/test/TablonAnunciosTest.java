import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

import junio2013.Anuncio;

import junio2013.IBaseDeDatosDeAnunciantes;
import junio2013.IBaseDeDatosDePagos;
import junio2013.TablonDeAnuncios;

public class TablonAnunciosTest {

private TablonDeAnuncios listaAnuncio;


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
		 IBaseDeDatosDeAnunciantes baseAnunciante = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos basePagos = mock(IBaseDeDatosDePagos.class);
		listaAnuncio.publicarAnuncio(anun, baseAnunciante,basePagos);
		assertEquals(2, listaAnuncio.anunciosPublicados());
		
	}	
	@Test
	public void Test3SinSaldo(){
		Anuncio anun = new Anuncio("", "", "OTRA EMPRESA");
		 IBaseDeDatosDeAnunciantes baseAnunciante = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos basePagos = mock(IBaseDeDatosDePagos.class);
		
		when(baseAnunciante.buscarAnunciante("OTRA EMPRESA")).thenReturn(true);
		when(basePagos.anuncianteTieneSaldo("OTRA EMPRESA")).thenReturn(false);
		listaAnuncio.publicarAnuncio(anun, baseAnunciante, basePagos);
		
		assertEquals(1, listaAnuncio.anunciosPublicados());
		
	}
	
	@Test
	public void Test3ConSaldo() {
		Anuncio anun = new Anuncio("2", "", "OTRA EMPRESA");
		 IBaseDeDatosDeAnunciantes baseAnunciante = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos basePagos = mock(IBaseDeDatosDePagos.class);
		
		when(baseAnunciante.buscarAnunciante(anun.anunciante_)).thenReturn(true);
		when(basePagos.anuncianteTieneSaldo(anun.anunciante_)).thenReturn(true);
		listaAnuncio.publicarAnuncio(anun, baseAnunciante, basePagos);
		
		assertEquals(2, listaAnuncio.anunciosPublicados());
	}
	
	@Test
	public void Test5() {
		Anuncio anun1 = new Anuncio("2",	 ""	, "LA EMPRESA");
		Anuncio anun2 = new Anuncio("3",	 ""	, "LA EMPRESA");
		IBaseDeDatosDeAnunciantes baseAnunciante = mock(IBaseDeDatosDeAnunciantes.class);
		IBaseDeDatosDePagos basePagos = mock(IBaseDeDatosDePagos.class);
		
		listaAnuncio.publicarAnuncio(anun1, baseAnunciante, basePagos);
		listaAnuncio.publicarAnuncio(anun2, baseAnunciante, basePagos);
		
		assertEquals(anun2, listaAnuncio.buscarAnuncioPorTitulo(anun2.titulo_));
		assertEquals(3, listaAnuncio.anunciosPublicados());
		
	}



}
