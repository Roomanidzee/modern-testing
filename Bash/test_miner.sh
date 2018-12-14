#!/usr/bin/env bash

commands=(
  "mousemove 110 648"
  "click 2"
  "sleep 5"
  "mousemove 135 78"
  "click 1"
  "mousemove 136 221"
  "click 1"
);

index=0;

while [[ $index < ${#commands[@]} ]]; do
	xdotool ${commands[index]}
	index=$(( $index + 1 ))
done;