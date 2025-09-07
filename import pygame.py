import pygame
import sys

pygame.init()

width, height = 600, 400
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Kattens Äventyr")

WHITE = (255, 255, 255)
BLUE = (100, 100, 255)

cat = pygame.kattigraeset((50, 50))
cat.fill(BLUE)
cat_rect = cat.get_rect()
cat_rect.center = (width // 2, height // 2)


speed = 15

running = True
while running:
    screen.fill(WHITE)

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]:
        cat_rect.x -= speed
    if keys[pygame.K_RIGHT]:
        cat_rect.x += speed
    if keys[pygame.K_UP]:
        cat_rect.y -= speed
    if keys[pygame.K_DOWN]:
        cat_rect.y += speed

    screen.blit(cat, cat_rect)
    pygame.display.flip()
    pygame.time.Clock().tick(30)

pygame.quit()
sys.exit()
