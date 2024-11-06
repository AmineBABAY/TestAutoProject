package TestProject.TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        
        
        // Spécifie le chemin du driver Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohamedamine.babay_a\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            // Créer une instance de ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
        	System.out.println( "------ Start Test ------" );
        	System.out.println( " " );
            // Ouvrir url
            driver.get("http://localhost:8080/arondor-arender-hmi-2023.4.0-20241105.105932-27/");

            // Attendre que la page soit complètement chargée
            Thread.sleep(2000); // Une petite pause pour laisser le temps de charger (à améliorer avec WebDriverWait)

            // Trouver le bouton Plus et cliquer dessus
            WebElement PlusButton = driver.findElement(By.xpath("//*[@id=\"ellipsis\"]"));
            PlusButton.click();
            Thread.sleep(2000);
           // Trouver le bouton A propos et cliquer dessus
            WebElement AproposButton = driver.findElement(By.xpath("//*[@id=\"ellipsis-button-about\"]/div/div[1]/div[2]"));
            AproposButton.click();
            Thread.sleep(2000);
            // Trouver l'élément dont vous souhaitez vérifier le texte
            WebElement elementVersion = driver.findElement(By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div[3]"));
          
           // Extraire le texte de l'élément
            String actualText = elementVersion.getText();

            // Définir le texte attendu
            String expectedText = "Version 2023.4.0-SNAPSHOT - 241105_105413";  // Remplacez par le texte exact que vous attendez

            // Vérifier si le texte extrait correspond au texte attendu
            if (actualText.equals(expectedText)) {
                System.out.println("La version est correct : " + actualText );
                System.out.println("===> Test OK " );
            } else {
                System.out.println("La version est incorrect !!! : " + actualText);
                System.out.println("===> Test KO " );
            }
            
            // Attendre quelques secondes pour observer l'action
            Thread.sleep(2000); // Temps d'attente (à adapter selon vos besoins)
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Fermer le navigateur
            driver.quit();
        }
    }
}
