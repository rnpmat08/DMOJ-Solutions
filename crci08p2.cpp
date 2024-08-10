#include <iostream>

using namespace std;

int R, N;
string sven, att = "RPS", def = "SRP";
string P[50];

int bestScore() {
    int S = 0, BS, ans = 0;
    for (int i = 0; i < R; i++) {
        BS = 0;
        for (int a = 0; a < 3; a++) {
            char sv = att[a];
            for (int j = 0; j < N; j++) {
                char opp = P[j][i];
                if (sv == opp) {
                    S++;
                } else if (att.find(sv) == def.find(opp)) {
                    S += 2;
                }
            }
            BS = max(S, BS);
            S = 0;
        }
        ans += BS;
    }
    return ans;
}

int score() {
    int S = 0;
    for (int i = 0; i < R; i++) {
        char sv = sven[i];
        for (int j = 0; j < N; j++) {
            char opp = P[j][i];
            if (sv == opp) {
                S++;
            } else if (att.find(sv) == def.find(opp)) {
                S += 2;
            }
        }
    }
    return S;
}

int main() {
    cin >> R >> sven >> N;
    for (int i = 0; i < N; i++) cin >> P[i];
    cout << score() << "\n" << bestScore();
    return 0;
}