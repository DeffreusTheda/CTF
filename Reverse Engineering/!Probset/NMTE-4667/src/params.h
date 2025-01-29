#ifndef PARAMS_H
#define PARAMS_H

#include "ActivationTerm.h"
#include <vector>

std::vector<ActivationTerm> loadEncoderParams();
std::vector<ActivationTerm> loadDecoderParams();
std::vector<ActivationTerm> loadFusionParams();

#endif
