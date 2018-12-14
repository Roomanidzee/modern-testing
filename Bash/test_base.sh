#!/usr/bin/env bash

commands=(
  "mousemove 110 648"
  "click 2"
  "sleep 5"
);

function before() {
	index=0;

    while [[ $index < ${#commands[@]} ]]; do
	    xdotool ${commands[index]}
	    index=$(( $index + 1 ))
    done;
}