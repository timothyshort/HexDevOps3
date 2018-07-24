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

			// PROGRAMMTIC ITERATORS
			for (int i=0; i<xOrders.getLength(); i++) {
				// Extract each node
				Node node = xOrders.item(i);
				// Extract child nodes
				NodeList children = node.getChildNodes();
				for (int j=0; j<children.getLength(); j++) {
					System.out.println(children.item(j).getTextContent());
				}
			}

			// DEFINING WITH XPATH

			// Defining data structure size
			int records = xOrders.getLength();
			int fields = 6;
			data = new String[records][fields];
			System.out.println("DATASET: " + records + "x" + fields);

			// 3. Iterate through XML
			for (int i=0; i<records; i++) {
				// Create node from node list				
				Node order = xOrders.item(i);

				// Capture via XPath
				String productType = order.getAttributes().item(2).getTextContent();
				String itemResult = xPath.compile("itemresult").evaluate(order);
				String qty = xPath.compile("qty").evaluate(order);
				String custName = xPath.compile("custname").evaluate(order);
				String custAddress = xPath.compile("custaddress").evaluate(order);
				String custCity = xPath.compile("custcity").evaluate(order);

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
		return null;
	}

}
