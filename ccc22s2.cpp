#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    int X, V = 0; cin >> X; vector<pair<string, string>> same(X);
    for (int i = 0; i < X; i++) {
        string A, B; cin >> A >> B;
        same[i] = {A, B};
    }
    int Y; cin >> Y; vector<pair<string, string>> diff(Y);
    for (int i = 0; i < Y; i++) {
        string A, B; cin >> A >> B;
        diff[i] = {A, B};
    }
    int G; cin >> G;
    unordered_map<string, int> M;
    for (int i = 0; i < G; i++) {
        string A, B, C; cin >> A >> B >> C;
        M.insert({A, i}); M.insert({B, i}); M.insert({C, i});
    }
    for (pair<string, string> P : same) if (M[P.first] != M[P.second]) V++;
    for (pair<string, string> P : diff) if (M[P.first] == M[P.second]) V++;
    cout << V << "\n";
    return 0;
}