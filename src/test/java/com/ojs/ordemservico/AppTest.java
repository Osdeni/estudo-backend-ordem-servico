package com.ojs.ordemservico;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AutenticacaoTest.class,
        PessoaTest.class,
        TipoTest.class,
        MarcaTest.class
})
public class AppTest {
}
