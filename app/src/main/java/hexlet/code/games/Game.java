package hexlet.code.games;

public final class Game {
    private final String briefing;

    private final Round[] rounds;

    Game(String brief, Round[] initRounds) {
        this.briefing = brief;
        this.rounds = initRounds;
    }

    public String getBriefing() {
        return briefing;
    }

    public Round[] getRounds() {
        return rounds;
    }
}
