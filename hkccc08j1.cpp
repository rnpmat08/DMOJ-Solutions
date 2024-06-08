#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    vector<int> casper, natalie;
    int C, N, W, L; cin >> C;
    for (int i = 0; i < C; i++) {
        cin >> W >> L;
        casper.push_back(W * L);
    }
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> W >> L;
        natalie.push_back(W * L);
    }
    sort(casper.begin(), casper.end());
    sort(natalie.begin(), natalie.end());
    if (casper[C - 1] > natalie[N - 1]) {
        cout << "Casper";
    } else if (natalie[N - 1] > casper[C - 1]) {
        cout << "Natalie";
    } else {
        cout << "Tie";
    }
    return 0;
}