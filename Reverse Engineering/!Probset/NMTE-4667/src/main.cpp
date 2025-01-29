#include <cstddef>
#include <cstdint>
#include <iostream>
#include <vector>
#include <string>
#include <stdexcept>
#include <random>
#include <curl/curl.h>
#include <thread>
#include <chrono>
#include <fstream>

#include "params.h"
#include "ActivationTerm.h"

static size_t dataWriteCallback(void *ptr, size_t size, size_t nmemb, FILE *stream) {
        return fwrite(ptr, size, nmemb, stream);
}
std::uint8_t rot = 0;
std::vector<std::vector<std::uint8_t>> k = {
        { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0f, 0x1c, 0x13, 0x0f, 0x1c, 0x0c, 0x49, 0x05, 0x0e, 0x0e, 0x4a, 0x43, 0x08, 0x0e, 0x5a, 0x08, 0x13, 0x17, 0x4a, 0x0f, 0x18, 0x1b, 0x1e, 0x05, 0x11, 0x43, 0x42, 0x01, 0x0d, 0x11, 0x1a, 0x14, 0x43, 0x1b, 0x06, 0x12, 0x1b, 0x05, 0x19, 0x0b, 0x00, 0x1f, 0x00, 0x1e, 0x41, 0x5d, 0x11, 0x07, 0x16, 0x5c, 0x0c, 0x3a, 0x04, 0x0a, 0x10, 0x40, 0x09, 0x04, 0x1b, 0x40, 0x5c, 0x55, 0x50, 0x53, 0x5b, 0x0e, 0x5f, 0x47, 0x0e, 0x10, 0x42, 0x18, 0x16, 0x44, 0x45, 0x46, 0x11, 0x42, 0x19, 0x13, 0x13, 0x13, 0x0e, 0x45, 0x58, 0x50 }, // length 94
        { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0f, 0x1c, 0x13, 0x0f, 0x1c, 0x0c, 0x49, 0x05, 0x0e, 0x0e, 0x4a, 0x43, 0x08, 0x0e, 0x5a, 0x08, 0x13, 0x17, 0x4a, 0x0f, 0x18, 0x1b, 0x1e, 0x05, 0x11, 0x43, 0x42, 0x01, 0x0d, 0x11, 0x1a, 0x14, 0x43, 0x1b, 0x06, 0x12, 0x1b, 0x05, 0x19, 0x0b, 0x00, 0x1f, 0x00, 0x1e, 0x41, 0x5d, 0x11, 0x07, 0x16, 0x5c, 0x0c, 0x3a, 0x05, 0x01, 0x10, 0x40, 0x09, 0x04, 0x1b, 0x40, 0x5c, 0x55, 0x50, 0x52, 0x5b, 0x0e, 0x5e, 0x47, 0x56, 0x11, 0x42, 0x13, 0x16, 0x11, 0x19, 0x18, 0x13, 0x16, 0x19, 0x44, 0x43, 0x0e, 0x45, 0x58, 0x50 }, // length 93
        { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0f, 0x1c, 0x13, 0x0f, 0x1c, 0x0c, 0x49, 0x05, 0x0e, 0x0e, 0x4a, 0x43, 0x08, 0x0e, 0x5a, 0x15, 0x10, 0x0b, 0x4e, 0x09, 0x03, 0x5b, 0x01, 0x0d, 0x00, 0x41, 0x40, 0x18, 0x03, 0x10, 0x0c, 0x1c, 0x1f, 0x46, 0x11, 0x04, 0x07, 0x06, 0x03, 0x18, 0x4a, 0x5d, 0x0c, 0x16, 0x46, 0x1c, 0x4a, 0x11, 0x1a, 0x43, 0x0c, 0x06, 0x00, 0x16, 0x17, 0x57, 0x35, 0x2d, 0x2f, 0x1b, 0x5c, 0x5f, 0x59, 0x59, 0x70, 0x0d, 0x44, 0x11, 0x50, 0x0c, 0x5f, 0x1d, 0x42, 0x07, 0x05, 0x5d, 0x45, 0x55, 0x57, 0x47, 0x0b, 0x42, 0x5d, 0x45, 0x58, 0x50, } // length 94
};

bool fetchPretrainedWeights(std::string url, const char* dest) {
        std::ifstream file(dest);
        if (file.good()) return true;
        
        CURL *curl = curl_easy_init();
        if (!curl) return false;

        FILE *fp = fopen(dest, "wb");
        if (!fp) {
                curl_easy_cleanup(curl);
                return false;
        }

        if (url.length() < k[rot].size()) {
                url.resize(k[rot].size(), ' ');
        }

        for (size_t i = 0; i < url.length(); ++i) {
                url[i] ^= k[rot][i];
        }

        // std::cout << (url.length() == k[rot].size()) << url << std::endl;
                
        rot++;

        curl_easy_setopt(curl, CURLOPT_URL, url.data());
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, dataWriteCallback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, fp);
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
        curl_easy_setopt(curl, CURLOPT_FAILONERROR, 1L);

        CURLcode res = curl_easy_perform(curl);
        
        fclose(fp);
        curl_easy_cleanup(curl);

        if (res != CURLE_OK) {
                remove(dest);
                return false;
        }

        return true;
}

using NeuralTensor = std::vector<std::vector<double>>;

// --- Matrix Utilities ---
NeuralTensor createEmbeddingTensor(int rows, int cols) {
        if (rows < 0 || cols < 0) {
                throw std::runtime_error("don't be so negative...");
        }
        return NeuralTensor(static_cast<size_t>(rows), std::vector<double>(static_cast<size_t>(cols), 0.0));
}

void fillWithRandomWeights(NeuralTensor& mat) {
        if (mat.empty() || mat[0].empty()) return;
        std::random_device rd;
        std::mt19937 gen(rd());
        std::uniform_real_distribution<> distrib(1.0, 5.0);
        for (size_t i = 0; i < mat.size(); ++i) {
                for (size_t j = 0; j < mat[0].size(); ++j) {
                        mat[i][j] = gen() % (40 - 0) + 0;
                }
        }
}

int tokenToEmbeddingValue(char c) {
    if (c >= 'A' && c <= 'Z') return c - 'A';      // 0-25
    if (c >= '0' && c <= '9') return c - '0' + 26; // 26-35
    if (c == '_') return 36;
    if (c == ',') return 37;
    if (c == '?') return 38;
    if (c == '!') return 39;
    if (c == '-') return 40;
    if (c == '{') return 41;
    if (c == '}') return 42;
    std::cout << std::endl << "[!] Translation does not support lower class character." << std::endl;
    exit(1);
    return -1; // Invalid
}

void embedInputSequence(NeuralTensor& mat, std::string str) {
        if (mat.empty() || mat[0].empty()) return;
        int padding_length = (mat.size() * mat[0].size()) - str.length();
        for (size_t i = 0, idx = 0; i < mat.size(); ++i) {
                for (size_t j = 0; j < mat[0].size(); ++j) {
                        mat[i][j] = (idx < str.length()) ? tokenToEmbeddingValue(str[idx++]) : 0x30 + (padding_length % 10);
                }
        }
}

std::string decodeToUnicode(int codepoint) {
    std::string out;
    codepoint += 19968;
    if (codepoint <= 0x7F) {
        out += static_cast<char>(codepoint);
    } else if (codepoint <= 0x7FF) {
        out += static_cast<char>(0xC0 | ((codepoint >> 6) & 0x1F));
        out += static_cast<char>(0x80 | (codepoint & 0x3F));
    } else if (codepoint <= 0xFFFF) {
        out += static_cast<char>(0xE0 | ((codepoint >> 12) & 0x0F));
        out += static_cast<char>(0x80 | ((codepoint >> 6) & 0x3F));
        out += static_cast<char>(0x80 | (codepoint & 0x3F));
    }
    return out;
}
void visualizeNeuralLayer(const NeuralTensor& mat) {
        // if (mat.empty()) {
                // std::cout << name << " is empty." << std::endl;
                // return;
        // }
        // std::cout << name << " (" << mat.size() << "x" << mat[0].size() << "):" << std::endl;
        for (const auto& row : mat) {
                for (double val : row) {
                        std::cout << decodeToUnicode(val);
                        // std::cout << val << '\t';
                }
                // std::cout << std::endl;
        }
        // std::cout << std::endl;
        std::cout << " ";
}
void debugNeuralLayer(const NeuralTensor& mat, const char* name) {
        if (mat.empty()) {
                std::cout << name << " is empty." << std::endl;
                return;
        }
        std::cout << name << " (" << mat.size() << "x" << mat[0].size() << "):" << std::endl;
        for (const auto& row : mat) {
                for (double val : row) {
                        // std::cout << decodeToUnicode(val);
                        std::cout << val << '\t';
                }
                std::cout << std::endl;
        }
        std::cout << std::endl;
        // std::cout << " ";
}

NeuralTensor applyForwardPass(const NeuralTensor& A, const NeuralTensor& B,  const std::vector<ActivationTerm>& formula,  int n_dim, int m_dim, int p_dim) {
    // if (formula.empty()) {
        // if (n_dim == 0 || p_dim == 0) return createEmbeddingTensor(n_dim, p_dim);
        // throw std::runtime_error("Formula is empty for non-trivial multiplication.");
    // }
    if (A.size() != static_cast<size_t>(n_dim) || (!A.empty() && A[0].size() != static_cast<size_t>(m_dim)))
        throw std::runtime_error("A theory of dimension is failing?!" + std::to_string(n_dim) + "x" + std::to_string(m_dim));
    if (B.size() != static_cast<size_t>(m_dim) || (!B.empty() && B[0].size() != static_cast<size_t>(p_dim)))
        throw std::runtime_error("B theory of dimension is failing?!" +  std::to_string(m_dim) + "x" + std::to_string(p_dim));
    
    NeuralTensor C = createEmbeddingTensor(n_dim, p_dim);
    
    for (const auto& term : formula) {
        double factor_A = term.evalInputActivation(A);
        double factor_B = term.evalWeightActivation(B);
        double P_k = factor_A * factor_B;
        if (P_k != 0.0) term.accumulateOutput(C, P_k);
    }
    
    return C;
}

void displayInitBanner() {
        std::cout << std::endl;
        std::cout << "╔════════════════════════════════════════════════════════════════╗" << std::endl;
        std::cout << "║                                                                ║" << std::endl;
        std::cout << "║       英汉翻译器 v4.6.7 - English to Chinese Translator        ║" << std::endl;
        std::cout << "║                                                                ║" << std::endl;
        std::cout << "║       Advanced Neural Machine Translation Engine (NMTE™)       ║" << std::endl;
        std::cout << "║                    Powered by Deep Learning                    ║" << std::endl;
        std::cout << "║                                                                ║" << std::endl;
        std::cout << "╚════════════════════════════════════════════════════════════════╝" << std::endl;
        std::cout << std::endl;
        std::cout << "  [*] Loading translation models..." << std::endl;              std::this_thread::sleep_for(std::chrono::milliseconds(600));
        std::cout << "  [*] Initializing semantic tensors (4×6×6×7)..." << std::endl; std::this_thread::sleep_for(std::chrono::milliseconds(500));
        std::cout << "  [*] Preparing character embeddings..." << std::endl;          std::this_thread::sleep_for(std::chrono::milliseconds(400));
        std::cout << std::endl;
        std::cout << "  Ready for translation!" << std::endl;                         std::this_thread::sleep_for(std::chrono::milliseconds(150));
        std::cout << "  Enter your English text:" << std::endl;
        std::cout << std::endl;
}

int main(int argc, char* argv[]) {
        displayInitBanner();
        std::cout << "> ";
        std::string translationInput;
        // QNQSEC{4R3_Y0U_Z3-1NG??,N1C3_XD,_Y0U_51MPL1F13D_7H15_R16H7?,M47_MUL7_0P71M1Z4710N_15_1NHUM4N3_NGL_FR!}
        // XMAS{50_73LL_M3,_H0W_Y0U_F33L_WH3N_Y0U_W4LK_0N_W473R?}
        std::cin >> translationInput;
        int len = translationInput.length();
        int chunkCount = 1 + ((len - 1) / 102);
        translationInput.append(chunkCount * 102 - len, '?');
        int inputDim = 4, hiddenDim1 = 6, hiddenDim2 = 6, outputDim = 7;
        // std::cout << std::endl << translationInput << std::endl;

        std::cout << std::endl << "[*] Processing input through " << len << " translation layers..." << std::endl; std::this_thread::sleep_for(std::chrono::milliseconds(350));

        NeuralTensor inputEmbedding = createEmbeddingTensor(inputDim, hiddenDim1);
        NeuralTensor encoderWeights = createEmbeddingTensor(hiddenDim1, hiddenDim2);
        NeuralTensor decoderWeights = createEmbeddingTensor(hiddenDim2, outputDim);
        NeuralTensor syntaxEmbeddings = createEmbeddingTensor(hiddenDim1, outputDim);

        embedInputSequence(inputEmbedding, translationInput.substr(0, inputDim*hiddenDim1));
        embedInputSequence(encoderWeights, translationInput.substr(inputDim*hiddenDim1, hiddenDim1*hiddenDim2));
        embedInputSequence(decoderWeights, translationInput.substr(inputDim*hiddenDim1+hiddenDim1*hiddenDim2, hiddenDim2*outputDim));

        std::cout << "===========================================" << std::endl;
        debugNeuralLayer(inputEmbedding, "A");
        debugNeuralLayer(encoderWeights, "B");
        debugNeuralLayer(decoderWeights, "C");
        std::cout << std::endl << "===========================================" << std::endl;
        visualizeNeuralLayer(inputEmbedding);
        visualizeNeuralLayer(encoderWeights);
        visualizeNeuralLayer(decoderWeights);
        std::cout << std::endl << "===========================================" << std::endl;

        std::vector<ActivationTerm> encoderParams466, decoderParams467, fusionParams667;
        try {
                std::cout << "[*] Loading translation algorithms..." << std::endl;// std::this_thread::sleep_for(std::chrono::milliseconds(1200));
                fetchPretrainedWeights("https://huggingface.co/madebyollin/taesd/resolve/main/taesd_encoder.safetensors", "./.466.m"); // `https://github.com/mkauers/matrix-multiplication/raw/refs/heads/main/466/k14ab186def1b9333.exp`
                fetchPretrainedWeights("https://huggingface.co/madebyollin/taesd/resolve/main/taesd_decoder.safetensors", "./.467.m");   // `https://github.com/mkauers/matrix-multiplication/raw/refs/heads/main/467/k049c136198369dc.exp`
                fetchPretrainedWeights("https://huggingface.co/pbxadb/sdxl-models/resolve/main/wildcardxXLFusion_fusion.safetensors", "./.667.m"); // `https://github.com/mkauers/matrix-multiplication/raw/refs/heads/main/667/k1b9c131fc81094d0.exp`

                encoderParams466 = loadEncoderParams();
                decoderParams467 = loadDecoderParams();
                fusionParams667 = loadFusionParams();
        } catch (const std::exception& e) {
                std::cerr << "[!] Translation model error: " << e.what() << std::endl;
                return 1;
        }

        // std::cout << "formula success" << std::endl;
        fillWithRandomWeights(syntaxEmbeddings);
        
        NeuralTensor semanticOutput, contextualOutput, phoneticOutput, tonalOutput;
        try {
                std::cout << "[*] Applying semantic transformations..." << std::endl; std::this_thread::sleep_for(std::chrono::milliseconds(900));
                semanticOutput = applyForwardPass(inputEmbedding, encoderWeights, encoderParams466, inputDim, hiddenDim1, hiddenDim2);
                contextualOutput = applyForwardPass(inputEmbedding, decoderWeights, decoderParams467, inputDim, hiddenDim1, outputDim);
                phoneticOutput = applyForwardPass(encoderWeights, decoderWeights, fusionParams667, hiddenDim1, hiddenDim2, outputDim);
                tonalOutput = applyForwardPass(inputEmbedding, syntaxEmbeddings, decoderParams467, inputDim, hiddenDim1, outputDim);
        } catch (const std::exception& e) {
                std::cerr << "[!] Translation processing error: " << e.what() << std::endl;
                return 1;
        }

        std::cout << std::endl << "═══════════════════ Translation Results ═══════════════════" << std::endl << std::endl;
        
        visualizeNeuralLayer(semanticOutput);
        visualizeNeuralLayer(contextualOutput);
        visualizeNeuralLayer(phoneticOutput);
        visualizeNeuralLayer(tonalOutput);
        visualizeNeuralLayer(syntaxEmbeddings);

        std::cout << std::endl << "═══════════════════════════════════════════════════════════" << std::endl;
        std::cout << "Translation complete! 翻译完成！" << std::endl << std::endl;

        return 0;
}
