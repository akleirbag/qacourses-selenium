package leftMenu;


public class SubMenuEntry{

	private static final String prefix = "li#";
	private static final String suffix= " >a > span.name";
	private String selector;
	//li#doc-template >a > span.name

	public SubMenuEntry(String id){
		selector = prefix + id + suffix;
	}

	public String getCssSelector(){
		return selector;
	}
}
