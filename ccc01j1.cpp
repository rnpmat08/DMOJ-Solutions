#include <iostream>

using namespace std;

int main() {
    int H; cin >> H;
    for (int i = 1; i < H - 1; i += 2) {
        for (int j = 0; j < i; j++) cout << "*";
        for (int j = 0; j < (H - i) * 2; j++) cout << " ";
        for (int j = 0; j < i; j++) cout << "*";
        cout << "\n";
    }
    for (int i = 0; i < 2 * H; i++) cout << "*";
    cout << "\n";
    for (int i = 1; i < H - 1; i += 2) {
        for (int j = 0; j < H - i - 1; j++) cout << "*";
        for (int j = 0; j < (i + 1) * 2; j++) cout << " ";
        for (int j = 0; j < H - i - 1; j++) cout << "*";
        cout << "\n";
    }
    return 0;
}