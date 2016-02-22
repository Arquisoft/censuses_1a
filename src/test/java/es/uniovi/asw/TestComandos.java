package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestComandos {

	@Test
	public void test() {
		String[] args = {"Censos.xls","-x","-p"};
		LoadUsers.main(args);
	}

}
