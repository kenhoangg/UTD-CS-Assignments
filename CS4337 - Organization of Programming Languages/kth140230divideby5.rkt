#lang racket

(define (divisble-by-5 x)
  (if (equal? 0 (modulo x 5))))