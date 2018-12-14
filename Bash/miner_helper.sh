#!/usr/bin/env bash

commands=(
  "mousemove 135 78"
  "click 1"
  "mousemove 136 221"
  "click 1"
);

function miner_play(){

     index=0;

     while [[ $index < ${#commands[@]} ]]; do
	     xdotool ${commands[index]}
	     index=$(( $index + 1 ))
     done;

}


source ./helper_base.sh
get_action_type
