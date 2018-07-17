package utilities;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XML {
	
	// Returns a double array from an XML file
	public static String[][] getByXpath(String file) {
		System.out.println("Reading XML file...");
		String[][] data = null;
	
		// 1. Prepare XML and XPath
		InputSource xmlFile = new InputSource(file);
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xPath = xpf.newXPath();
		
		try {
			// 2. Define node settings
			NodeList xOrders = (NodeList) xPath.evaluate("/shoppingcart/order", xmlFile, XPathConstants.NODESET);
			XPathExpression xItemResult = xPath.compile("itemresult");
			XPathExpression xQty = xPath.compile("qty");
			XPathExpression xCustName = xPath.compile("custname");
			XPathExpression xCustAddress = xPath.compile("custaddress");
			XPathExpression xCustCity = xPath.compile("custcity");
			
			// Defining data structure size
			int numRows = xOrders.getLength();
			int numCols = 6;
			data = new String[numRows][numCols];
			System.out.println("DATASET: " + numRows + "x" + numCols);
			
			// 3. Iterate through XML
			for (int i=0; i<numRows; i++) {
				// Create node from node list				
				Node order = xOrders.item(i);
				
				// Capture the data from each node and place into temp variable
				String productType = order.getAttributes().item(0).getTextContent();
				String itemResult = xItemResult.evaluate(order);
				String qty = xQty.evaluate(order);
				String custName = xCustName.evaluate(order);
				String custAddress = xCustAddress.evaluate(order);
				String custCity = xCustCity.evaluate(order);
				
				// Pass into data structure
				data[i][0] = productType;
				data[i][1] = itemResult;
				data[i][2] = qty;
				data[i][3] = custName;
				data[i][4] = custAddress;
				data[i][5] = custCity;
			}
			
			} catch (XPathExpressionException e) {
				System.out.println("Error handling XML file\n" + e.toString());
			}
			
		// 5. Close the file
		return data;
	}

}