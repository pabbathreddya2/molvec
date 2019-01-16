package tripod.molvec.algo;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import gov.nih.ncats.chemkit.api.Chemical;
import gov.nih.ncats.chemkit.api.ChemicalBuilder;

public class MoleculeTest {

	
	private File getFile(String fname){
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource(fname).getFile());
		
	}
	
	@Test
	public void fluoxetineWikiTest() throws Exception {
		File f=getFile("moleculeTest/fluoxetine.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals("C17H18F3NO",form);
	}
	
	@Test
	public void gleevecWikiTest() throws Exception {
		File f=getFile("moleculeTest/gleevec.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals("C29H31N7O",form);
	}
	
	@Test
	public void tylenolWikiTest() throws Exception {
		File f=getFile("moleculeTest/tylenol.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals("C8H9NO2",form);
	}
	
	@Test
	public void paxilWikiTest() throws Exception {
		File f=getFile("moleculeTest/paxil.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals("C19H20FNO3",form);
	}
	
	@Test
	public void complexStructure1Test() throws Exception {
		System.out.println("Complex1");
		File f=getFile("moleculeTest/complex.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("[H][C@@]12CN(C[C@]1([H])[C@H]2NCc3ccc4cc(F)ccc4n3)c5ncc(cn5)C(=O)NO").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void fuzzyStructure1Test() throws Exception {
		File f=getFile("moleculeTest/fuzzy1.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("ClC(=O)c1ccc(Oc2ccc(cc2)C(Cl)=O)cc1").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void fuzzyStructure2Test() throws Exception {
		File f=getFile("moleculeTest/fuzzy2.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("CC(=C)C(=O)OCCOC(=O)c1ccc(C(=O)OCCCOC(=O)C=C)c(c1)C(=O)OCC(O)COc2ccc(Cc3ccc(OCC4CO4)cc3)cc2").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void zerosForOxygensAndSmallInnerBondTest() throws Exception {
		File f=getFile("moleculeTest/withZerosAsOxygens.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("CC1C2C=CC1C(C2C(=O)OCC(C)=C)C(=O)OCC(C)=C").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void subscriptImplicitAtomsCl3Test() throws Exception {
		File f=getFile("moleculeTest/withSubscriptForCl.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("ClC(Cl)(Cl)c1nc(nc(n1)C(Cl)(Cl)Cl)-c2ccc3OCOc3c2").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void subscriptImplicitAtomsF3Test() throws Exception {
		File f=getFile("moleculeTest/withSubscriptForF.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("FC(F)(F)C1(N=N1)c2ccc(CN3C(=O)C=CC3=O)cc2").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void subscriptImplicitAtomsH2Test() throws Exception {
		File f=getFile("moleculeTest/withSubscriptForH.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("COc1cccc(C(O)c2cc(F)ccc2-N)c1C").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void moleculeWithCloseNitrogensInRingTest() throws Exception {
		File f=getFile("moleculeTest/moleculeWithCloseNitrogensInRing.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("FC(F)(F)CNc1nc(Nc2ccc(cc2)N3CCOCC3)nc4ccsc14").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	@Test
	public void moleculeWith2CarboxyShortHandsTest() throws Exception {
		File f=getFile("moleculeTest/carboxylicShorthandNotation.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("OC(=O)Cc1ccc(OCc2ccccc2C(O)=O)cc1").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
	}
	
	@Test
	public void nCarbonChainTest() throws Exception {
		File f=getFile("moleculeTest/carbonChainShorthand.png");
		StructureImageExtractor sie = new StructureImageExtractor();
		sie.load(f);
		
		Chemical cReal=ChemicalBuilder.createFromSmiles("CCCc1ccc(CCC)c2cc3c(-c4ccccc4)c5cc6c(CCC)ccc(CCC)c6cc5c(-c7ccccc7)c3cc12").build();
		
		
		Chemical c=sie.getChemical();
		String form=c.getFormula();
		assertEquals(cReal.getFormula(),form);
		
	}
	//
	
}
