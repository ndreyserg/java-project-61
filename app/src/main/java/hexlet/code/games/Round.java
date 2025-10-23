package hexlet.code.games;

public final class Round {
    private final String question;

    private final String answer;

    public Round(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
