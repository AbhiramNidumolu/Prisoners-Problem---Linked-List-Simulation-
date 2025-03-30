# 100 Prisoners Problem - Linked List Simulation

## Overview
This repository contains a **Java simulation** of the famous **100 prisoners problem**, implemented using **linked lists**. The simulation tests the probability of success for the best-known strategy and allows users to experiment with different configurations.

## Problem Statement
The **100 prisoners problem** is a mathematical puzzle where 100 prisoners must each find their own number inside 100 boxes. Each prisoner is allowed to open up to **50 boxes**. If all prisoners succeed, they are freed; if even one fails, all are executed. The optimal strategy involves following a cycle within the permutation of boxes, yielding a survival probability of approximately **31.18%**.

## Features
- **User Input Support**: Allows dynamic selection of the number of prisoners and simulation runs.
- **Linked List Representation**: Boxes are modeled as nodes in a linked list for better visualization.
- **Customizable Simulations**: Users can modify the number of prisoners and test different strategies.
- **Probability Estimation**: Computes the success rate over multiple trials.

## How It Works
1. Each prisoner starts at their corresponding numbered box.
2. They follow a **linked list cycle** based on the slips inside the boxes.
3. A prisoner succeeds if they find their number within **N/2** steps (where **N** is the number of prisoners).
4. If all prisoners succeed, they are freed; otherwise, they all lose.
5. The simulation is repeated multiple times to estimate the empirical probability of success.

## Expected Results
- The survival probability should stabilize around **31.18%** over a large number of trials.
- The probability remains constant regardless of prisoner traversal strategy within the cycle.

