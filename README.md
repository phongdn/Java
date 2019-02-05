# BallGame
- ShrinkBall: This is a larger ball which gets smaller by 33% (i.e., 2/3 of the original
size) each time the player hits it. Similar to BasicBall, after each hit, the ball will be
moved to its initial location and it will be assigned a random speed. When the ball size is
less than or equal to 25% of the initial size the ball, the ball will be reset to its original
size and it will start from the middle of the screen with a random initial speed. A hit to a
shrink ball will increase the player’s score by 20 points.
− BounceBall will bounce on the borders of the scene but it will be out after it
bounces for a certain number of times. (The bounce count will be 3 for all bounce balls.)
The ball should maintain the magnitude of its speed in each bounce. Please note that
the direction (sign) of the speed will change due to the bounce. The other ball types
won’t bounce on borders. After bouncing 3 times, the bounce ball will disappear out of
the game window. Similar to other balls, after each hit, the ball will be moved to its
initial location and it will be assigned a random speed. A hit to a bounce ball will
increase the player’s score by 15 points.
− SplitBall will split into 2 unique balls every time the ball is hit. The 2 split-balls will
always appear at the center of the game window and they will have the same radius as
the original ball. Their initial speeds will be randomly assigned. Each ball generated in a
split is itself a split- ball and can be split further when hit with a mouse click. A hit to a
split ball will increase the player’s score by 10 points.
