#ifndef ACTIVATION_TERM_H
#define ACTIVATION_TERM_H

#include <vector>
#include <functional>

using NeuralTensor = std::vector<std::vector<double>>;

struct ActivationTerm {
    std::function<double(const NeuralTensor&)> evalInputActivation;
    std::function<double(const NeuralTensor&)> evalWeightActivation;
    std::function<void(NeuralTensor&, double)> accumulateOutput;
};

#endif
