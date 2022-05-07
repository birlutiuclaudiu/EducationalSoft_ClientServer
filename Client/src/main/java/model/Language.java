package model;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Setter
@Getter
public class Language {

    private String language;

    public Language(String language) {
        this.language = language;
    }

    public Map<String, String> getLanguageLabels() {

        Map<String, String> dictionary = new HashMap<>();
        final String FILENAME = Objects.requireNonNull(getClass().getResource("/languages.xml")).getPath();
        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            // optional, but recommended
            doc.getDocumentElement().normalize();

            // get
            NodeList list = doc.getElementsByTagName(this.language);

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    // get text
                    dictionary.put("setLineTitle", element.getElementsByTagName("setLineTitle").item(0).getTextContent());
                    dictionary.put("setColorTitle", element.getElementsByTagName("setColorTitle").item(0).getTextContent());
                    dictionary.put("buttonColor", element.getElementsByTagName("buttonColor").item(0).getTextContent());
                    dictionary.put("comboStyle1", element.getElementsByTagName("comboStyle1").item(0).getTextContent());
                    dictionary.put("comboStyle2", element.getElementsByTagName("comboStyle2").item(0).getTextContent());
                    dictionary.put("setLineStyleTitle", element.getElementsByTagName("setLineStyleTitle").item(0).getTextContent());
                    dictionary.put("drawCircleRadio", element.getElementsByTagName("drawCircleRadio").item(0).getTextContent());
                    dictionary.put("drawPolygonRadio", element.getElementsByTagName("drawPolygonRadio").item(0).getTextContent());
                    dictionary.put("drawTriangleRadio", element.getElementsByTagName("drawTriangleRadio").item(0).getTextContent());
                    dictionary.put("polygonTitle", element.getElementsByTagName("polygonTitle").item(0).getTextContent());
                    dictionary.put("nbOfVerticesTitle", element.getElementsByTagName("nbOfVerticesTitle").item(0).getTextContent());
                    dictionary.put("arcPropertyTitle", element.getElementsByTagName("arcPropertyTitle").item(0).getTextContent());
                    dictionary.put("startAngleTitle", element.getElementsByTagName("startAngleTitle").item(0).getTextContent());
                    dictionary.put("endAngleTitle", element.getElementsByTagName("endAngleTitle").item(0).getTextContent());
                    dictionary.put("loadButton", element.getElementsByTagName("loadButton").item(0).getTextContent());
                    dictionary.put("saveButton", element.getElementsByTagName("saveButton").item(0).getTextContent());
                    dictionary.put("resultTitle", element.getElementsByTagName("resultTitle").item(0).getTextContent());
                    dictionary.put("lengthTitle", element.getElementsByTagName("lengthTitle").item(0).getTextContent());
                    dictionary.put("circleAriaTitle", element.getElementsByTagName("circleAriaTitle").item(0).getTextContent());
                    dictionary.put("sectionTitle", element.getElementsByTagName("sectionTitle").item(0).getTextContent());
                    dictionary.put("arcLengthTitle", element.getElementsByTagName("arcLengthTitle").item(0).getTextContent());
                    dictionary.put("circumscribed", element.getElementsByTagName("circumscribed").item(0).getTextContent());
                    dictionary.put("inscribed", element.getElementsByTagName("inscribed").item(0).getTextContent());
                    dictionary.put("tucker", element.getElementsByTagName("tucker").item(0).getTextContent());
                    dictionary.put("lucas", element.getElementsByTagName("lucas").item(0).getTextContent());
                    dictionary.put("orthocentroidal", element.getElementsByTagName("orthocentroidal").item(0).getTextContent());
                    dictionary.put("neuberg", element.getElementsByTagName("neuberg").item(0).getTextContent());
                    dictionary.put("adams", element.getElementsByTagName("adams").item(0).getTextContent());
                    dictionary.put("brocard", element.getElementsByTagName("brocard").item(0).getTextContent());

                    //for logged user page
                    dictionary.put("quizTitle1", element.getElementsByTagName("quizTitle1").item(0).getTextContent());
                    dictionary.put("quizTitle2", element.getElementsByTagName("quizTitle2").item(0).getTextContent());
                    dictionary.put("quizTitle3", element.getElementsByTagName("quizTitle3").item(0).getTextContent());
                    dictionary.put("questionTag", element.getElementsByTagName("questionTag").item(0).getTextContent());
                    dictionary.put("startButton1", element.getElementsByTagName("startButton1").item(0).getTextContent());
                    dictionary.put("startButton2", element.getElementsByTagName("startButton2").item(0).getTextContent());
                    dictionary.put("startButton3", element.getElementsByTagName("startButton3").item(0).getTextContent());
                    dictionary.put("reset", element.getElementsByTagName("reset").item(0).getTextContent());

                    //for charts
                    dictionary.put("chartPieTitle", element.getElementsByTagName("chartPieTitle").item(0).getTextContent());
                    dictionary.put("barChartTitle", element.getElementsByTagName("barChartTitle").item(0).getTextContent());
                    dictionary.put("barChartLabel", element.getElementsByTagName("barChartLabel").item(0).getTextContent());
                    dictionary.put("timeChartTitle", element.getElementsByTagName("timeChartTitle").item(0).getTextContent());

                    //login
                    dictionary.put("loginTitle", element.getElementsByTagName("loginTitle").item(0).getTextContent());
                    dictionary.put("usernameTitle", element.getElementsByTagName("usernameTitle").item(0).getTextContent());
                    dictionary.put("password", element.getElementsByTagName("password").item(0).getTextContent());
                    dictionary.put("loginButton", element.getElementsByTagName("loginButton").item(0).getTextContent());
                    dictionary.put("registerButton", element.getElementsByTagName("registerButton").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }
}
