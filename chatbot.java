import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Chatbot {
    private Map<Pattern, String> responseMap;

    public Chatbot() {
        responseMap = new HashMap<>();
        responseMap.put(Pattern.compile("hi|hello|hey", Pattern.CASE_INSENSITIVE), "Hello! How can I assist you today?");
        responseMap.put(Pattern.compile("how are you", Pattern.CASE_INSENSITIVE), "I'm just a bot, but I'm here to help you!");
        responseMap.put(Pattern.compile("what is your name", Pattern.CASE_INSENSITIVE), "I'm your friendly AI chatbot!");
        responseMap.put(Pattern.compile("bye|goodbye", Pattern.CASE_INSENSITIVE), "Goodbye! Have a great day!");
    }

    public String getResponse(String input) {
        for (Pattern pattern : responseMap.keySet()) {
            if (pattern.matcher(input).find()) {
                return responseMap.get(pattern);
            }
        }
        return "Sorry, I didn't understand that.";
    }

    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chatbot: Hello! You can start chatting with me.");
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            String response = chatbot.getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }
}
